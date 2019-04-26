function jump(){
    var student_number=document.getElementById("student_number").value;
    if(student_number=="" || parseInt(student_number) < 10000 || parseInt(student_number) > 99999){
        alert("学号为10000至99999之间数字");
        return ;
    }
    location.href=location.href+"info/"+student_number;
}
function checkQuerybyName() {
    return checkchinese(document.query_byname.student_name.value);
}
function checkchinese(str){
    var reg=/^[u4E00-u9FA5]+$/;
    debugger;
    if(reg.test(str)) {
        alert("姓名必须为汉字");
        return false;
    }
    //alert("here");
    return true;
}
function checkAdd(){
    var student_number=document.add_student.student_number.value;
    var ret=true;
    $.ajaxSettings.async = false;
    $.get("/isexist",{student_number:student_number},function (data) {
        //alert(student_number);
        //alert(data);
        if(data==true){
            alert("该学号已存在");
            ret=false;
            //alert(ret);
        }
    });
    $.ajaxSettings.async = true;
    //alert("after"+ret);
    if(ret==false)
        return false;
    if(document.add_student.sex)
        return checkchinese(document.add_student.name.value);
}
function checkQueryList() {
    debugger;
    var w1=document.query_list.w1.value;
    var w2=document.query_list.w2.value;
    var w3=document.query_list.w3.value;
    if(w1==w2 || w1==w3 || w2==w3){
        alert("三权重必须不同");
        return false;
    }
    return true;
}