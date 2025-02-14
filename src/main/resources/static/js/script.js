// scripts.js
document.addEventListener("DOMContentLoaded", function () {
    // Vérifier la disponibilité d'un livre avant l'emprunt
    const bookIdInput = document.getElementById("bookId");
    const checkAvailabilityButton = document.getElementById("checkAvailability");
    const availabilityMessage = document.getElementById("availabilityMessage");

    if (checkAvailabilityButton) {
        checkAvailabilityButton.addEventListener("click", function () {
            const bookId = bookIdInput.value;
            fetch(`/api/books/${bookId}/disponibilite`)
                .then(response => response.json())
                .then(data => {
                    availabilityMessage.textContent = data ? "Disponible" : "Indisponible";
                    availabilityMessage.style.color = data ? "green" : "red";
                })
                .catch(error => console.error("Erreur:", error));
        });
    }
});