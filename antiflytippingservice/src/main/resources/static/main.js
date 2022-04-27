var map;
var script;

function fillMap(dumps) {
    ymaps.ready(init);

    function init() {
        let image;
        if(map){
            map.destroy()
        }

        map = new ymaps.Map('map', {
            center: [58.0119320871105,56.22310774677379],
            zoom: 15,
            controls: ['zoomControl', 'typeSelector', 'fullscreenControl'],
            behaviors: ['drag', 'scrollZoom', 'dblClickZoom', 'multiTouch']
        }, {
            searchControlProvider: 'yandex#search'
        });

        let clusterer = new ymaps.Clusterer({
            preset: 'islands#invertedVioletClusterIcons',
            groupByCoordinates: false,
            clusterDisableClickZoom: true,
            clusterHideIconOnBalloonOpen: false,
            geoObjectHideIconOnBalloonOpen: false
        });

        let getPointData = function (index, image) {
            return {
                balloonContentHeader: '<font size=3><b>Dump information</b></font>',
                balloonContentBody:
                    '<img src="' + image + '" height="140" width="140" alt="Свалка"> <br/> ' +
                    '<b>Area: </b> ? m<sup><small>2</small></sup> <br/>' +
                    '<b>Detection date: </b>' + dumps[index].date + '<br/>' +
                    '<b>Date of last measurement: </b>' + dumps[index].date + '<br/>' +
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
            image = "data:image/jpg;base64," + dumps[i].image;
            geoObjects[i] = new ymaps.Placemark([dumps[i].latitude, dumps[i].longitude], getPointData(i, image), getPointOptions());
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


