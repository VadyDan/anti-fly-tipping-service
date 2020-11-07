var map;

function fillMap(dumps) {
    ymaps.ready(init);

    function init() {
        if(map){
            map.destroy()
        }
        map = new ymaps.Map('map', {
            center: [58.0119320871105,56.22310774677379],
            zoom: 15,
            controls: ['zoomControl'],
            behaviors: ['drag']
        });
        let clusterer = new ymaps.Clusterer({
            preset: 'islands#invertedVioletClusterIcons',
            groupByCoordinates: false,
            clusterDisableClickZoom: true,
            clusterHideIconOnBalloonOpen: false,
            geoObjectHideIconOnBalloonOpen: false
        });
        getPointData = function (index) {
            return {
                balloonContentHeader: '<font size=3><b>Dump information</b></font>',
                balloonContentBody: '<p>'+dumps[index].latitude+'</p>',
                clusterCaption: 'Dump number <strong>' + index + '</strong>'
            };
        };
        getPointOptions = function () {
            return {
                preset: 'islands#violetIcon'
            };
        };

        geoObjects = [];

        for(var i = 0, len = dumps.length; i < len; i++) {
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


