function submitPenumpang(){
    var namaPenumpang = document.form_penumpang.nama_penumpang.value;
    var jenkelPenumpang = document.form_penumpang.jenkel_penumpang.value;
    var asalPenumpang = document.form_penumpang.asal.value;
    var tujuanPenumpang = document.form_penumpang.tujuan.value;
    var pesawatPenumpang = document.form_penumpang.pesawat_penumpang.value;


    if(namaPenumpang === '' || namaPenumpang === undefined
    || asalPenumpang === '' || asalPenumpang === undefined
    || tujuanPenumpang === '' || tujuanPenumpang === undefined
    || jenkelPenumpang === '' || jenkelPenumpang === undefined
    || pesawatPenumpang === '' || pesawatPenumpang === undefined){
        alert('Data not valid');
        return false;
    }else{
        return true;
    }
}