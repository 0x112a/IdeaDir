# Organisation and Packages（包的组织结构）



The Fyne project is split into many packages, each providing different types of functionality（**n.**实用；符合实际；设计目的；设计功能）. They are as follows:

- `fyne.io/fyne/v2`

  This import provides the basic definitions common to all Fyne code

  including data types and interfaces.

- `fyne.io/fyne/v2/app`

  The app package provides the APIs that start a new application.

  Normally you only require `app.New()` or `app.NewWithID()`.

- `fyne.io/fyne/v2/canvas`

  The canvas package provides all of the drawing APIs within Fyne.

  The complete Fyne toolkit is made up of these primitive graphical types.（完整的Fyne工具包由这些原始图形类型组成。）

- `fyne.io/fyne/v2/container`

  The container package provides containers that are used to lay out and organise applications.

- `fyne.io/fyne/v2/data/binding`

  The binding package contains ways of binding data sources to widgets.

- `fyne.io/fyne/v2/data/validation`

  The validation package provides tolling for validating data inside widgets.（验证程序包提供措施用于验证小部件内的数据。）

- `fyne.io/fyne/v2/dialog`

  The dialog package contains dialogs such as confirm, error and file save/open.

- `fyne.io/fyne/v2/layout`

  The layout package provides various layout implementations for use

  with containers (discussed in a later tutorial).

- `fyne.io/fyne/v2/storage`

  The storage package provides storage access and management functionality.

- `fyne.io/fyne/v2/test`

  Applications can be tested more easily using the tools within the test

  package.

- `fyne.io/fyne/v2/widget`

  Most graphical applications are created using a collection of widgets.

  All the widgets and interactive elements within Fyne are in this package.(Fyne中的所有窗口小部件和交互式元素都在此包中。)

# Example Code

```
package main

import (
	"fyne.io/fyne/v2"
	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/canvas"
	"fyne.io/fyne/v2/container"
	"fyne.io/fyne/v2/data/binding"
	"fyne.io/fyne/v2/data/validation"
	"fyne.io/fyne/v2/dialog"
	"fyne.io/fyne/v2/layout"
	"fyne.io/fyne/v2/storage"
	"fyne.io/fyne/v2/storage/repository"
	"fyne.io/fyne/v2/test"
	"fyne.io/fyne/v2/theme"
	"fyne.io/fyne/v2/widget"
)

func main() {
}
```

# Packaging and Distribution

Packaging for multiple operating systems can be a complex task. Graphical applications typically have icons and metadata associated with them as well as specific formats required to integrate with each environment.

The `fyne` command provides support for preparing applications to be distributed across all the platforms the toolkit supports. Running “fyne package” will create an application ready to be installed on your computer and to be distributed to other computers by simply copying the created files from the current directory.

For Windows it will create a `.exe` file with icons embedded. For a macOS computer it will create a `.app` bundle and for Linux it will generate a `.tar.xz` file that can be installed in the usual manner (or by running `make install` inside the extracted folder).

Of course you can still run your applications using the standard Go tools if you prefer.

Copy Example

# Example Code

```shell
#!/bin/sh

go get fyne.io/fyne/v2/cmd/fyne

go build
fyne package -icon mylogo.png

# result is a platform specific package
# for the current operating system.
```



# Beginner to Expert

Fyne is designed to be easy to get started with and simple to build large applications across multiple platforms. It is also designed to allow custom elements to be added and contributed.(它还旨在允许添加和贡献的自定义元素)

Through this tutorial you will find topics that grow in complexity but none should be beyond a proficient(**n.**专家；能手；老手；adj. 熟练的；精通的) programmer. Every step of the way you can copy the examples into your IDE and see them in action.

By the end of this tour you will know all of the building blocks of Fyne and its tools. We can’t wait to see what you build.

If at any point you want to start giving back we welcome contributions, bug reports and conversations with people that are using the toolkit. You can find more about contributing by visiting our [contributors page](https://fyne.io/contribute.html) or [github repository](https://github.com/fyne-io/fyne/).

Please continue to our first tutorial “[Basics](https://developer.fyne.io/tour/basics/)”.

Copy Example

# Example Code

```
package main

import (
	"net/url"

	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/widget"
)

func main() {
	myApp := app.New()
	myWindow := myApp.NewWindow("Hello")

	bugURL, _ := url.Parse("https://github.com/fyne-io/fyne/issues/new")
	myWindow.SetContent(widget.NewHyperlink("Report a bug", bugURL))

	myWindow.ShowAndRun()
}
```

