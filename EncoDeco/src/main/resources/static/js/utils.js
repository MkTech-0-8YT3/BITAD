function encodeData() {
    var formData = parseFormData("#encodingForm");
    $.ajax("/encode", { data: JSON.stringify(formData), contentType: 'application/json', type:'POST'}).then(function (value) {
        alert(value);
    });
}

function getFlag() {
    document.getElementById("encodedFlagText").innerText="";
    $.ajax("/flag", { type:'GET'}).then(function (value) {
        document.getElementById("encodedFlagText").innerText=value;
    });
}

function unlockFlag() {
    var formData = parseFormData("#keyForm");
    $.ajax("/unlock", { data: JSON.stringify(formData), contentType: 'application/json', type:'POST'}).then(function (value) {
        document.getElementById("encodedFlagText").innerText=value;
    });
}

function parseFormData(formName) {
    var formDataToParse = $(formName).serializeArray();
    var parsedData = {};
    $.each(formDataToParse,
        function(i, v) {
            parsedData[v.name] = v.value;
        });
    return parsedData;
}

function disableKeypressSubmit() {
    $(document).on("keypress", 'form', function (e) {
        var code = e.keyCode || e.which;
        if (code === 13) {
            e.preventDefault();
            return false;
        }
    });
}