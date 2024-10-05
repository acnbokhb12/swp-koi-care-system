 const imageInput = document.getElementById('imageInput');
const imagePreview = document.getElementById('imagePreview');

imageInput.addEventListener('change', function() {
    const file = this.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            imagePreview.src = e.target.result;
            imagePreview.style.display = 'block'; // Hiện ảnh khi file được chọn
        };
        reader.readAsDataURL(file);
    } else {
        imagePreview.style.display = 'none'; // Ẩn ảnh nếu không có file nào được chọn
    }
});
const formsAccept = document.getElementById('fomr_fill-news');
formsAccept.addEventListener('submit',(e)=>{
    const isConfirmed = confirm('Are you sure you want to submit this news?');
    if(!isConfirmed){
        e.preventDefault();
    }
});