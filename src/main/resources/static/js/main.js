document.addEventListener('DOMContentLoaded', function() {
    fetch('/utilisateur/api/utilisateurs')
        .then(response => response.json())
        .then(data => {
            const utilisateurTableBody = document.getElementById('utilisateurTableBody');
            data.forEach(utilisateur => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${utilisateur.id}</td>
                    <td>${utilisateur.nom}</td>
                    <td>${utilisateur.prenom}</td>
                    <td>${utilisateur.phone}</td>
                    <td>${utilisateur.email}</td>
                    <td>${utilisateur.cin}</td>
                    <td>${new Date(utilisateur.dateNais).toLocaleDateString()}</td>
                `;
                utilisateurTableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching utilisateurs:', error));
});


