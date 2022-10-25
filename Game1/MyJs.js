/**
 * Created by 86180 on 2022/9/1.
 */
function getStyle(obj){
    return getComputedStyle(obj) || obj.currentStyle;
}