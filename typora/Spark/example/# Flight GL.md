# Flight GL



[![img](https://cdn.jsdelivr.net/gh/apache/echarts-website@asf-site/examples/data-gl/thumb/lines3d-flights-gl.webp?_v_=1630499963508) Flights GL Flights GL](https://echarts.apache.org/examples/zh/editor.html?c=lines3d-flights-gl&gl=1)



```js
var uploadedDataURL = ROOT_PATH + "/data-gl/asset/data/flights.json";

myChart.showLoading();

$.getJSON(uploadedDataURL, function(data) {

    myChart.hideLoading();

    function getAirportCoord(idx) {
        return [data.airports[idx][3], data.airports[idx][4]];
    }
    var routes = data.routes.map(function (airline) {
        return [
            getAirportCoord(airline[1]),
            getAirportCoord(airline[2])
        ];
    });

    myChart.setOption({
        geo3D: {
            map: 'world',
            shading: 'realistic',
            silent: true,
            environment: '#333',
            realisticMaterial: {
                roughness: 0.8,
                metalness: 0
            },
            postEffect: {
                enable: true
            },
            groundPlane: {
                show: false
            },
            light: {
                main: {
                    intensity: 1,
                    alpha: 30
                },
                ambient: {
                    intensity: 0
                }
            },
            viewControl: {
                distance: 70,
                alpha: 89,

                panMouseButton: 'left',
                rotateMouseButton: 'right'
            },

            itemStyle: {
                color: '#000'
            },

            regionHeight: 0.5
        },
        series: [{
            type: 'lines3D',

            coordinateSystem: 'geo3D',

            effect: {
                show: true,
                trailWidth: 1,
                trailOpacity: 0.5,
                trailLength: 0.2,
                constantSpeed: 5
            },

            blendMode: 'lighter',

            lineStyle: {
                width: 0.2,
                opacity: 0.05
            },

            data: routes
        }]
    });

    window.addEventListener('keydown', function () {
        myChart.dispatchAction({
            type: 'lines3DToggleEffect',
            seriesIndex: 0
        });
    });
});
```







这是一段java代码，如果看不懂就不要看了，大致意思是把数据都除以10000，然后列表奇数位依次相加、偶数位依次相加，两两一组即为各个公交站点地理坐标，每个列表代表1个线路。

![image-20210913151725988](/home/monica/.config/Typora/typora-user-images/image-20210913151725988.png)