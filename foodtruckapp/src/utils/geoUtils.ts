
function toRad(degrees) {
    return degrees * Math.PI / 180;
}
export const  getDistance = (lat1: number, lng1: number, lat2: number, lng2: number):String=> {
    var R = 6371;

    // 将经纬度转换为弧度
    var radLat1 = toRad(lat1);
    var radLng1 = toRad(lng1);
    var radLat2 = toRad(lat2);
    var radLng2 = toRad(lng2);

    // 计算经纬度的差值
    var dLat = radLat2 - radLat1;
    var dLng = radLng2 - radLng1;

    // 应用球面余弦定理计算距离
    var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(radLat1) * Math.cos(radLat2) *
            Math.sin(dLng / 2) * Math.sin(dLng / 2);
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    var distance = R * c;

    return getNumberFormat(distance * 1000, 2) ;

}
export const getNumberFormat = (value, fixed = 2) => {
    if (!value) return Number(0).toFixed(fixed)
    value = Number(value).toFixed(fixed)
    const intPart = Number(value) - Number(value) % 1
    const intPartFormat = intPart.toString().replace(/(\d)(?=(?:\d{3})+$)/g, "$1,");
    const value2Array = value.toString().split(".");
    if (value2Array.length === 2) {
        const floatPart = value2Array[1].toString();
        return intPartFormat + "." + floatPart;
    } else {
        return intPartFormat;
    }
};