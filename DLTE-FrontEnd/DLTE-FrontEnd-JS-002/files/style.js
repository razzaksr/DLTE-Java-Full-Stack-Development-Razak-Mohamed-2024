window.onload=()=>{
    document.getElementsByTagName("table")[0].style.backgroundColor='blue'
    document.getElementsByTagName("table")[0].style.color='white'
    document.getElementsByTagName("table")[0].style.textAlign='center'
    document.getElementsByTagName("table")[0].style.border='10px'
    document.getElementsByTagName("table")[0].style.borderStyle='double'
    document.getElementsByTagName("table")[0].style.boxShadow='1px 10px 3px red'
    document.getElementsByTagName("iframe")[0].style.height='100vh'
}

const alter=()=>{
    var page = document.getElementById("user-source").value
    page+=".html"
    document.getElementsByTagName("iframe")[0].src=page
}