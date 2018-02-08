function submitPesawat(){
    var idPesawat = document.form_pesawat.id_pesawat.value;
    var namaPesawat = document.form_pesawat.nama_pesawat.value;

    if(idPesawat === '' || idPesawat === undefined ||
    namaPesawat === '' || namaPesawat === undefined){
        alert('Data not valid');
        return false;
    }else{
        return true;
    }

}