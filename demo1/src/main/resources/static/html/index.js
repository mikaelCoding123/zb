

var i;
$(function (){

    i = [1,22,1.2,1.231]
    $.each(i,function (id,val){
        console.log(id+"====="+val);
    })


    $("#buie").click(function (){
        console.log("buie")
        i=[1,2,2,3]
        for(i;i<i.length;i++){
            console.log(i+"====="+i[i])
        }

    });


})
