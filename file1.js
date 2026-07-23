// Select Elements
const form = document.querySelector("form");
const nameInput = document.querySelector("#name");
const emailInput = document.querySelector("#email");
const phoneInput = document.querySelector("#phone");
const messageInput = document.querySelector("#message");

// Character Counter
const counter = document.createElement("p");
counter.style.color = "gray";
counter.style.fontSize = "14px";
messageInput.after(counter);

messageInput.addEventListener("input", () => {
    counter.textContent = `${messageInput.value.length}/250 Characters`;
});

// Validation Functions
const validateName = () => {
    const regex = /^[A-Za-z ]{3,30}$/;

    if (!regex.test(nameInput.value.trim())) {
        showError(nameInput, "Name should contain only letters (3-30 characters)");
        return false;
    }

    removeError(nameInput);
    return true;
};

const validateEmail = () => {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!regex.test(emailInput.value.trim())) {
        showError(emailInput, "Invalid Email Address");
        return false;
    }

    removeError(emailInput);
    return true;
};

const validatePhone = () => {
    const regex = /^[6-9]\d{9}$/;

    if (!regex.test(phoneInput.value.trim())) {
        showError(phoneInput, "Enter a valid 10-digit phone number");
        return false;
    }

    removeError(phoneInput);
    return true;
};

const validateMessage = () => {
    if (messageInput.value.trim().length < 10) {
        showError(messageInput, "Message must contain at least 10 characters");
        return false;
    }

    removeError(messageInput);
    return true;
};

// Error Functions
function showError(input, message) {

    removeError(input);

    const error = document.createElement("small");
    error.className = "error";
    error.style.color = "red";
    error.textContent = message;

    input.style.border = "2px solid red";

    input.parentNode.insertBefore(error, input.nextSibling);
}

function removeError(input) {

    input.style.border = "1px solid #ccc";

    if (
        input.nextSibling &&
        input.nextSibling.classList &&
        input.nextSibling.classList.contains("error")
    ) {
        input.nextSibling.remove();
    }
}

// Live Validation
nameInput.addEventListener("blur", validateName);
emailInput.addEventListener("blur", validateEmail);
phoneInput.addEventListener("blur", validatePhone);
messageInput.addEventListener("blur", validateMessage);

// Form Submit
form.addEventListener("submit", function (e) {

    e.preventDefault();

    const isValid =
        validateName() &&
        validateEmail() &&
        validatePhone() &&
        validateMessage();

    if (!isValid) return;

    // Create Object
    const userData = {
        name: nameInput.value,
        email: emailInput.value,
        phone: phoneInput.value,
        message: messageInput.value,
        submittedAt: new Date().toLocaleString()
    };

    // Save in Local Storage
    let users = JSON.parse(localStorage.getItem("users")) || [];
    users.push(userData);
    localStorage.setItem("users", JSON.stringify(users));

    console.log(userData);

    alert("Form Submitted Successfully!");

    form.reset();
    counter.textContent = "0/250 Characters";
});

// Display Stored Users
console.log(JSON.parse(localStorage.getItem("users")));
