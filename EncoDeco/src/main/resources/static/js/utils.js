function encodeData() {
    var formDataToParse = $("#encodingForm").serializeArray();
    var parsedData = {};
    $.each(formDataToParse,
        function(i, v) {
            parsedData[v.name] = v.value;
        });
    $.ajax("/encode", { data: JSON.stringify(parsedData), contentType: 'application/json', type:'POST'}).then(function (value) {
        alert(value);
    });
}