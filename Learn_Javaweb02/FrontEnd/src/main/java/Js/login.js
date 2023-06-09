function checkIllegal(e) {
    if(e.value.length < 6) {
        e.setAttribute("class", "login-main-menu-info-error")
    }else {
        e.setAttribute("class", "login-main-menu-info-base")
    }
}

function checkLeave(e) {
    if(e.value.length < 6 && e.value.length > 0) {
        e.setAttribute("class", "login-main-menu-info-error")
    }else {
        e.setAttribute("class", "login-main-menu-info-base")
    }
}

function httpsXhr() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://lys2021.com/');
    xhr.send();
}