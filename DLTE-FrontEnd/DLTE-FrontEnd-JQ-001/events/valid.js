$(document).ready(()=>{
    performValidate()
})

const performValidate=()=>{
    $("form[name=modify]").submit((eve)=>{
        //eve.preventDefault()
        var isValid=true
        const name = $("input[name=applicantName]").val()
        const dob = $("input[name=applicantDOB]").val()
        const limit = $("input[name=expectedLimit]").val()
        const purpose = $("input[name=cardPurpose]").val()
        const type = $("input[name=cardType]").val()
        const email = $("input[name=applicantEmail]").val()
        const contact = $("input[name=applicantContact]").val()
        const pan = $("input[name=applicantPAN]").val()

        $("#nameErr").text("")
        $("#limitErr").text("")
        $("#purposeErr").text("")

        // data validation name
        try{
            if(!(/[A-Za-z]/).test(name)){
                throw "Requires only alphabets"
            }
        }
        catch(message){
            isValid=false
            $("#nameErr").text(message)
        }

        // data validation limit
        try{
            if(!(/[0-9]{5,}/).test(limit)){
                throw "Requires only positive number"
            }
        }
        catch(message){
            isValid=false
            $("#limitErr").text(message)
        }

        // data validation limit
        try{
            if(purpose==='Select Purpose'||purpose===''){
                throw "Requires valid purpose"
            }
        }
        catch(message){
            isValid=false
            $("#purposeErr").text(message)
        }

        if(isValid){
            alert("Form validated")
            this.submit()
        }
        else{
            eve.preventDefault()
        }
    })
}