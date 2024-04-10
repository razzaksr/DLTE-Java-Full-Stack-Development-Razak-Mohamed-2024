let repository=[]

var create=()=>{
    var myForm = document.forms['application']
    const name = myForm.applicantName.value
    const dob = myForm.applicantDOB.value
    const expectedLimit = myForm.expectedLimit.value
    const purpose = myForm.cardPurpose.value
    const type = myForm.cardType.value
    const contact = myForm.applicantContact.value
    const email = myForm.applicantEmail.value
    const pan = myForm.applicantPAN.value
    const obj = {
        "applicantName":name,"applicantContact":contact,"applicantDob":dob,
        "applicantEmail":email,"applicantLimit":expectedLimit,
        "applicantPan":pan,"cardPurpose":purpose,"cardType":type
    }
    loadStore()
    repository.push(obj)
    alert(JSON.stringify(obj)+" has pushed")
    dumpStore()
}

const iterate=()=>{
    loadStore()
    let content = ""
    repository.map((each)=>{
        content+="<tr>"
        content+="<td>"+each.applicantName+"</td><td>"+
        each.applicantPan+"</td><td>"+each.applicantContact+"</td><td>"+
        each.applicantLimit+"</td><td></tr>"
    })
    document.getElementById("records").innerHTML=content
}

const dumpStore=()=>{
    localStorage.setItem('applicants',JSON.stringify(repository))
}

let loadStore=()=>{
    var data = localStorage.getItem('applicants')
    repository=JSON.parse(data)
    // repository.map((each)=>{
    //     alert(JSON.stringify(each))
    // })
}

function initiate(){
    repository.push({
        "applicantName":"Divija",
        "applicantDob":"2002-01-01",
        "applicantLimit":50000,
        "cardPurpose":"Shopping",
        "cardType":"Rupay",
        "applicantEmail":"divijapatwardhan@gmail.com",
        "applicantContact":76545676565,
        "applicantPan":"ABCDE1233E"
    })
    repository.push(
        {
            "applicantName":"Arundhathi",
            "applicantDob":"2003-10-14",
            "applicantLimit":100000,
            "cardPurpose":"International",
            "cardType":"VISA",
            "applicantEmail":"arundhathinayak@gmail.com",
            "applicantContact":8765567876567,
            "applicantPan":"BCDEF9238R"
        })
    repository.push(
        {
            "applicantName":"Akash",
            "applicantDob":"2002-01-01",
            "applicantLimit":100000,
            "cardPurpose":"Fuel",
            "cardType":"VISA",
            "applicantEmail":"akashmanjummel@gmail.com",
            "applicantContact":567876567563,
            "applicantPan":"ERERD7678D"
        })
    repository.push(
            {
                "applicantName":"Rakesh",
                "applicantDob":"2002-11-20",
                "applicantLimit":50000,
                "cardPurpose":"Travel",
                "cardType":"Rupay",
                "applicantEmail":"rakeshkumarshetty@gmail.com",
                "applicantContact":765678767834,
                "applicantPan":"ERSVH8784H"
            })
            // alert(repository.toString())
    localStorage.setItem('applicants',JSON.stringify(repository))
}

// window.addEventListener('load',initiate)
// window.addEventListener('load',loadStore)
// document.addEventListener('mouseenter',iterate)
// document.addEventListener('mouseleave',()=>{
//     document.getElementById('records').innerHTML=""
// })