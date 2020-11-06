ymaps.ready(init);

function init() {
    var map = new ymaps.Map('map', {
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
            balloonContentHeader: '<font size=3><b><a target="_blank" href="https://yandex.ru">Здесь может быть ваша ссылка</a></b></font>',
            balloonContentBody: '<p>Ваше имя: <input name="login"></p><p>Телефон в формате 2xxx-xxx:  <input></p><p><input type="submit" value="Отправить"></p>',
            balloonContentFooter: '<font size=1>Информация предоставлена: </font> балуном <strong>метки ' + index + '</strong>',
            clusterCaption: 'метка <strong>' + index + '</strong>'
        };
    };
    getPointOptions = function () {
        return {
            preset: 'islands#violetIcon'
        };
    };

    geoObjects = [];

    for(var i = 0, len = points.length; i < len; i++) {
        geoObjects[i] = new ymaps.Placemark(window.points[i], getPointData(i), getPointOptions());
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