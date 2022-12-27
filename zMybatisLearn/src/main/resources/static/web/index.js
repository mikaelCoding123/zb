$(function () {
    console.log("index")
    $.ajax({
        url: "/plus",
        dataType: 'json',
        type: "get",
        contentType: 'application/json;charset=utf-8',
        async: false,//同步
        success: function (data) {
            if (data.data.pokid == 12) {
                console.log("success")
            }
        }
    });


})