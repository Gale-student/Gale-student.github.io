/**
 * Created by Administrator on 2021/10/19.
 */
function getStyle(obj){
    return getComputedStyle(obj) || obj.currentStyle;
}
function shaking(obj){
    var arr = [-10,10,-5,5,0];
    var left = getStyle(obj).left;
    var x = parseInt(left);
    var timer = null;
    var i = 0;
    timer = setInterval(function(){
        obj.style.left = (x + arr[i]) + "px";
        i ++;
        if(i >= arr.length){
            clearInterval(timer);
        }
    },50);

}