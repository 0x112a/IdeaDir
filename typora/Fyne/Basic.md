## Basic

# Application and RunLoop

For a GUI application to work it needs to run an event loop (sometimes called a runloop) that processes user interactions and drawing events. In Fyne this is started using the `App.Run()` or `Window.ShowAndRun()` functions. One of these must be called from the end of your setup code in the `main()` function.

An application should only have one runloop and so you should only call `Run()` once in your code. Calling it a second time will cause errors.

For desktop runtimes an app can be quit directly by calling `App.Quit()` (mobile apps do not support this) - normally not needed in developer code. An application will also quit once all the windows are closed. See also that functions executed after `Run()` will not be called until the application exits.

Copy Example

# Example Code

```
package main

import (
	"fmt"

	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/widget"
)

func main() {
	myApp := app.New()
	myWindow := myApp.NewWindow("Hello")
	myWindow.SetContent(widget.NewLabel("Hello"))

	myWindow.Show()
	myApp.Run()
	tidyUp()
}

func tidyUp() {
	fmt.Println("Exited")
}
```

# Window Handling

Windows are created using `App.NewWindow()` and need to be shown using the `Show()` function. The helper method `ShowAndRun()` on `fyne.Window` allows you to show your window and run the application at the same time.

If you wish to show a second window you must only call the `Show()` function. This is illustrated in the `showAnother` function.

By default a window will be the right size to show its content by checking the `MinSize()` function (more on that in later examples). You can set a larger size by calling the `Window.Resize()` function.

Be aware that the desktop environment may have constraints that cause windows to be smaller than requested.

Copy Example

# Example Code

```go
package main

import (
	"time"

	"fyne.io/fyne/v2"
	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/widget"
)

func main() {
	myApp := app.New()
	myWindow := myApp.NewWindow("Hello")
	myWindow.SetContent(widget.NewLabel("Hello"))

	go showAnother(myApp)
	myWindow.ShowAndRun()
}

func showAnother(a fyne.App) {
	time.Sleep(time.Second * 5)

	win := a.NewWindow("Shown later")
	win.SetContent(widget.NewLabel("5 seconds later"))
	win.Resize(fyne.NewSize(200, 200))
	win.Show()

	time.Sleep(time.Second * 2)
	win.Close()
}
```



# Canvas and CanvasObject

In Fyne a `Canvas` is the area which an application is drawn within. Each window has a canvas which you can access with `Window.Canvas()` but usually you will find functions on `Window` that avoid accessing the canvas.

Everything that can be drawn in Fyne is a type of `CanvasObject`. The example here opens a new window and then shows different types of primitive graphical element by setting the content of the window canvas. There are many ways that each type of object can be customised as shown with the text and circle examples. By running `changeContent` within a goroutine (using the `go `prefix, these graphical changes execute after the window has been shown.

As well as changing the content shown using `Canvas.SetContent()` it is possible to change the content that is currently visible. If, for example, you change the `FillColour` of a rectangle you can request a refresh of this existing component using `rect.Refresh()`.

Copy Example

# Example Code

```go
package main

import (
	"image/color"
	"time"

	"fyne.io/fyne/v2"
	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/canvas"
	"fyne.io/fyne/v2/theme"
)

func main() {
	myApp := app.New()
	myWindow := myApp.NewWindow("Canvas")
	myCanvas := myWindow.Canvas()

	green := color.NRGBA{R: 0, G: 180, B: 0, A: 255}
	text := canvas.NewText("Text", green)
	text.TextStyle.Bold = true
	myCanvas.SetContent(text)
	go changeContent(myCanvas)

	myWindow.Resize(fyne.NewSize(100, 100))
	myWindow.ShowAndRun()
}

func changeContent(c fyne.Canvas) {
	time.Sleep(time.Second * 2)

	blue := color.NRGBA{R: 0, G: 0, B: 180, A: 255}
	c.SetContent(canvas.NewRectangle(blue))

	time.Sleep(time.Second * 2)
	c.SetContent(canvas.NewLine(color.Gray{Y: 180}))

	time.Sleep(time.Second * 2)
	red := color.NRGBA{R: 0xff, G: 0x33, B: 0x33, A: 0xff}
	circle := canvas.NewCircle(color.White)
	circle.StrokeWidth = 4
	circle.StrokeColor = red
	c.SetContent(circle)

	time.Sleep(time.Second * 2)
	c.SetContent(canvas.NewImageFromResource(theme.FyneLogo()))
}
```



# Container and Layouts

In the previous example we saw how to set a `CanvasObject` to the content of a `Canvas`, but it is not very useful to only show one visual element. To show more than one item we use the `Container` type.

As the `fyne.Container` also is a `fyne.CanvasObject`, we can set it to be the content of a `fyne.Canvas`. In this example we create 3 text objects and then place them in a container using the `container.NewWithoutLayout()` function. As there is no layout set we can move the elements around like you see with `text2.Move()`.

A `fyne.Layout` implements a method for organising items within a container. By uncommenting the `container.New()` line in this example you alter the container to use a grid layout with 2 columns. Run this code and try resizing the window to see how the layout automatically configures the contents of the window. Notice also that the manual position of `text2` is ignored by the layout code.

To find out more jump to the [`Layout`](https://developer.fyne.io/tour/layout/) and [`Container`](https://developer.fyne.io/tour/container/) sections of this tour.

Copy Example

# Example Code

```go
package main

import (
	"image/color"

	"fyne.io/fyne/v2"
	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/canvas"
	"fyne.io/fyne/v2/container"
	//"fyne.io/fyne/v2/layout"
)

func main() {
	myApp := app.New()
	myWindow := myApp.NewWindow("Container")
	green := color.NRGBA{R: 0, G: 180, B: 0, A: 255}

	text1 := canvas.NewText("Hello", green)
	text2 := canvas.NewText("There", green)
	text2.Move(fyne.NewPos(20, 20))
	content := container.NewWithoutLayout(text1, text2)
	// content := container.New(layout.NewGridLayout(2), text1, text2)

	myWindow.SetContent(content)
	myWindow.ShowAndRun()
}
```



# Widgets

A `fyne.Widget` is a special type of container that has additional logic associated with it. In widgets the logic is separate from the way that it looks (also called the `WidgetRenderer`).

Widgets are also types of `CanvasObject` and so we can set the content of our window to a single widget. See how we create a new `widget.Entry` and set it as the content of the window in this example.

As we saw in the previous example you can also add multiple objects to a canvas using a `Container` and the same can be done with sets of widgets to start building up graphical application interface.

Next take some time to learn about other “[Canvas Objects](https://developer.fyne.io/tour/canvas/)”.

Copy Example

# Example Code

```go
package main

import (
	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/widget"
)

func main() {
	myApp := app.New()
	myWindow := myApp.NewWindow("Widget")

	myWindow.SetContent(widget.NewEntry())
	myWindow.ShowAndRun()
}
```