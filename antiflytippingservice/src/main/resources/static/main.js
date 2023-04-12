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
            type: 'yandex#satellite',
            controls: ['zoomControl', 'typeSelector', 'fullscreenControl'],
            behaviors: ['drag', 'scrollZoom', 'dblClickZoom', 'multiTouch']
        }, {
            searchControlProvider: 'yandex#search'
        });

        let clusterer = new ymaps.Clusterer({
            preset: 'islands#invertedVioletClusterIcons',
            groupByCoordinates: true,
            clusterDisableClickZoom: true,
            clusterHideIconOnBalloonOpen: false,
            geoObjectHideIconOnBalloonOpen: false
        });

        let getPointData = function (index, image) {
            return {
                balloonContentHeader: '<font size=3><b>Dump information</b></font>',
                balloonContentBody:
                    '<img src="' + image + '" height="140" width="140" alt="Свалка"> <br/> ' +
                    '<b>Area: </b> (soon) m<sup><small>2</small></sup> <br/>' +
                    '<b>ID = </b>' + dumps[index].id + '<br/>' +
                    '<b>Detection date: </b>' + formatDate(new Date(Date.parse(dumps[index].date))) + '<br/>' +
                    '<b>Date of last measurement: </b>' + formatDate(new Date(Date.parse(dumps[index].date))) + '<br/>' +
                    '<b/>Confidence: </b>' + dumps[index].confidence.toFixed(3) + ' <br/>' +
                    '<b>Address: </b> (soon) <br/>' +
                    '<b>Coordinates:</br> Latitude: </b>' + dumps[index].latitude + ' <br/>' +
                    '<b> Longitude: </b>' + dumps[index].longitude + ' <br/>' +
                    '<p style="text-align: center"><button id="btnSetDumpCheckedTrue" onclick="setDumpCheckedTrue(' + dumps[index].id + '); onClickChecked();">This is a DUMP!</button>' +
                    '<p style="text-align: center"><button id="btnSetDumpCorrectFalse" onclick="setDumpCorrectFalse(' + dumps[index].id + '); onClickCorrect();">This is NOT a dump!</button>',
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
            if (dumps[i].checked == false) {
                geoObjects[i] = new ymaps.Placemark([dumps[i].latitude, dumps[i].longitude], getPointData(i, image), getPointOptions());
            } else {
                geoObjects[i] = new ymaps.Placemark([dumps[i].latitude, dumps[i].longitude], getPointData(i, image));
            }
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

function padTo2Digits(num) {
    return num.toString().padStart(2, '0');
}

function formatDate(date) {
    return [
        padTo2Digits(date.getDate()),
        padTo2Digits(date.getMonth() + 1),
        date.getFullYear(),
    ].join('.');
}

function onClickCorrect() {
    let btn = document.getElementById("btnSetDumpCorrectFalse");
    btn.style.backgroundColor = 'salmon';
    btn.style.color = 'white';
}

function onClickChecked() {
    let btn = document.getElementById("btnSetDumpCheckedTrue");
    btn.style.backgroundColor = 'salmon';
    btn.style.color = 'green';
}


