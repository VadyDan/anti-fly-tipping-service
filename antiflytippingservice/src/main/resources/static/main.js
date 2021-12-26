var map;
var script;
function fillMap(dumps) {
    ymaps.ready(init);

    function init() {
        if(map){
            map.destroy()
        }
        map = new ymaps.Map('map', {
            center: [58.0119320871105,56.22310774677379],
            zoom: 15,
            controls: ['zoomControl', 'typeSelector', 'fullscreenControl'],
            behaviors: ['drag']
        });
        let clusterer = new ymaps.Clusterer({
            preset: 'islands#invertedVioletClusterIcons',
            groupByCoordinates: false,
            clusterDisableClickZoom: true,
            clusterHideIconOnBalloonOpen: false,
            geoObjectHideIconOnBalloonOpen: false
        });
        let getPointData = function (index) {
            return {
                balloonContentHeader: '<font size=3><b>Dump information</b></font>',
                balloonContentBody: '<img src="img/dump_example.png" height="140" width="140">' +
                    '<img src="img/dump_segmentation.png" height="140" width="140"> <br/> ' +
                    '<b>Area: </b> 118 m<sup><small>2</small></sup> <br/>' +
                    '<b>Detection date: </b> 12.09.2019 <br/>' +
                    '<b>Date of last measurement: </b> 12.10.2020 <br/>' +
                    '<b>Address: </b> Russia, Perm krai, Perm<br/>' +
                    '<b>Coordinates:</b> <br/> Latitude: ' + dumps[index].latitude +
                    '<br/> Longitude: ' + dumps[index].longitude + ' <br/>' +
                    '<p style="text-align: center"><button>Show all information</button>',
                clusterCaption: 'Dump number <strong>' + index + '</strong>'
            };
        };
        let getPointOptions = function () {
            return {
                preset: 'islands#violetIcon'
            };
        };

        let geoObjects = [];

        let i = 0, len = dumps.length;
        for(; i < len; i++) {
            geoObjects[i] = new ymaps.Placemark([dumps[i].latitude, dumps[i].longitude], getPointData(i), getPointOptions());
        }

        clusterer.options.set({
            gridSize: 80,
            clusterDisableClickZoom: true
        });

        clusterer.add(geoObjects);
        map.geoObjects.add(clusterer);

        map.setBounds(clusterer.getBounds(), {
            checkZoomRange: true
        });
    }
}


