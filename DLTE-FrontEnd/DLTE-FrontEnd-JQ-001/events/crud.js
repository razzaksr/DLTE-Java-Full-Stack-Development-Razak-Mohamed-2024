$(document).ready(()=>{
    save()
})

// Jquery DOM

let repository=[]

const save=()=>{
    $("form[name=modify]").submit(()=>{
        // alert("CRUD about happen")
        const name = $("input[name=applicantName]").val()
        const dob = $("input[name=applicantDOB]").val()
        const limit = $("input[name=expectedLimit]").val()
        const purpose = $("input[name=cardPurpose]").val()
        const type = $("input[name=cardType]").val()
        const email = $("input[name=applicantEmail]").val()
        const contact = $("input[name=applicantContact]").val()
        const pan = $("input[name=applicantPAN]").val()

        const obj = {
            "applicantName":name,"applicantContact":contact,"applicantDob":dob,
            "applicantEmail":email,"applicantLimit":limit,
            "applicantPan":pan,"cardPurpose":purpose,"cardType":type
        }
        alert(JSON.stringify(obj))
        loadStore()
        repository.push(obj)
        dumpStore()
    })
}

const dumpStore=()=>{
    localStorage.setItem('applicants',JSON.stringify(repository))
}

let loadStore=()=>{
    var data = localStorage.getItem('applicants')
    repository=JSON.parse(data)
}