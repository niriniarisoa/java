function showPage(page) {
    $.ajax({
        url: '/api/' + page,
        type: 'GET',
        success: function(data) {
            $('#content').html(data);
        },
        error: function(error) {
            console.error("Erreur lors de la chargement de la page", error);
        }
    });
}