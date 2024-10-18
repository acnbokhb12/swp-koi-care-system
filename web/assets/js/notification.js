/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const closeToast = document.querySelector('.toast__close');
    const toastBig = document.getElementById('toast');
    closeToast.onclick = () =>{
        toastBig.classList.add('close_toast');
};

 setTimeout(function() {
        var toast = document.getElementById('toast');
        if (toast) {
            toast.style.opacity = '0'; // Tạo hiệu ứng mờ dần
            setTimeout(function() {
                toast.style.display = 'none'; // Ẩn hoàn toàn sau khi mờ
            }, 500); // Chờ 0.5 giây để hiệu ứng mờ hoàn thành trước khi ẩn
        }
}, 5000);