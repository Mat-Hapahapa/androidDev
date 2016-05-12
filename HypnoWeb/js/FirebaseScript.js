
//var Firebase = require("firebase");

var rootRef = new Firebase("https://hypnodata.firebaseio.com/web/data");

function tmp() {
    var usersRef = ref.child("TestChild");
    usersRef.set({
        TestName: {
            someStringOne: "StringOne",
            someStringTwo: "StringTWo"
        },
        TestName2: {
            someStringOne: "StringThree",
            someStringTwo: "StringFour"
        }
    });
};

function createUser() {
    rootRef.createUser({
        email: "matry7@gmail.com",
        password: "lol"
    }, function (error, userData) {
        if (error) {
            console.log("Error creating user:", error);
        } else {
            console.log("Successfully created user account with uid:", userData.uid);
        }
    });
};


function login() {
    var inputMail = document.getElementById("Username").value;
    var inputPass = document.getElementById("Password").value;
    rootRef.authWithPassword({
        email: inputMail,
        password: inputPass
    }, function (error, authData) {
        if (error) {
            console.log("Login Failed!", error);
            alert(error);
        } else {
            console.log("Authenticated successfully with payload:", authData);
            window.open('dashboard.html', '_self', false)
        }
    });
};


function handleFileSelect(evt) {

    var files = evt.target.files; // FileList object

    // Loop through the FileList and render image files as thumbnails.
    for (var i = 0, f; f = files[i]; i++) {

        // Only process image files.
        if (!f.type.match('audio.*')) {
            continue;
        }
        
        var reader = new FileReader();

        // Closure to capture the file information.
        reader.onload = (function (theFile) {
            return function (e) {
                // Render thumbnail.
                var span = document.createElement('span');
                span.innerHTML = ['<img class="thumb" src="', e.target.result,
                                  '" title="', escape(theFile.name), '"/>'].join('');
                document.getElementById('list').insertBefore(span, null);           
            };
        })(f);

        // Read in the image file as a data URL.
        reader.readAsDataURL(f);
    }
}

//if (document.getElementById("fileSelector") == null) { alert("shiiit") }

document.getElementById("fileSelector").addEventListener('change', handleFileSelect, false);
