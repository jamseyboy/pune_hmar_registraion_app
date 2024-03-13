document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Get the date value and format it to MySQL date format
    const dobInput = document.getElementById('dob');
    const dob = dobInput.valueAsDate ? dobInput.valueAsDate.toLocaleDateString('en-CA') : '';

    const formData = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        email: document.getElementById('email').value,
        gender: document.getElementById('gender').value,
        phoneNumber: document.getElementById('phoneNumber').value,
        dob: dob
    };

    fetch('http://localhost:8080/hsa/users/saveUser', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (response.ok) {
            alert('User information updated successfully');
        } else {
            throw new Error('Failed to update user information');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to update user information');
    });
});
