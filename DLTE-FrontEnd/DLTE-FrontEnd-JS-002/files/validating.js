const performValidate=()=>{
    var isValid=true

    var myForm = document.forms['application']
    const name = myForm.applicantName.value
    const dob = myForm.applicantDOB.value
    const expectedLimit = myForm.expectedLimit.value
    const purpose = myForm.cardPurpose.value
    const type = myForm.cardType.value
    const contact = myForm.applicantContact.value
    const email = myForm.applicantEmail.value
    const pan = myForm.applicantPAN.value

    var nameErr=document.getElementById("nameErr")
    var dobErr=document.getElementById("dobErr")
    var limitErr=document.getElementById("limitErr")
    var purposeErr=document.getElementById("purposeErr")
    var typeErr=document.getElementById("typeErr")
    var contactErr=document.getElementById("contactErr")
    var emailErr=document.getElementById("emailErr")
    var panErr=document.getElementById("panErr")

    // data validation name
    try{
        if(!(/[A-Za-z]/).test(name)){
            throw "Requires only alphabets"
        }
    }
    catch(message){
        isValid=false
        nameErr.innerHTML=message
    }

    // data validation limit
    try{
        if(!(/[0-9]{5,}/).test(expectedLimit)){
            throw "Requires only positive number"
        }
    }
    catch(message){
        isValid=false
        limitErr.innerHTML=message
    }

    // data validation limit
    try{
        if(purpose==='Select Purpose'||purpose===''){
            throw "Requires valid purpose"
        }
    }
    catch(message){
        isValid=false
        purposeErr.innerHTML=message
    }

    return isValid
}