let modalTitle = $('.modal-title');
let modalBody = $('.modal-body');
let modalFooter = $('.modal-footer');
let closeBookModal = $('<button id="close-book-modal" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>');

function viewBook(bookModal, bookId) {
	let viewBookTableHidden = $('#viewBookTable:hidden');
	$(bookModal).find(modalTitle).text('View Book');
	$(bookModal).find(modalBody).html(viewBookTableHidden.clone());	
	let viewBookTable = $('#viewBookTable');
	$(bookModal).find(viewBookTable).css('display', 'block');
	$(bookModal).find(modalFooter).append(closeBookModal);

	fetch('books?action=view&id=' + bookId)
        .then(response => ({status: response.status, data: response.json()}))
        .then(response => {
        	if (response.status == 200) {
        		response.data.then(value => {
		            $(bookModal).find('#bookId').text(value.id);
		            $(bookModal).find('#bookTitle').text(value.title);
		            $(bookModal).find('#bookEdition').text(value.edition);
		            $(bookModal).find('#bookIsbn').text(value.isbn);
		            $(bookModal).find('#bookAuthor').text(value.author);
		            $(bookModal).find('#bookYearPublished').text(value.yearPublished);
        		});
        	} else if (response.status == 404) {
        		response.data.then(value => {
        			$(bookModal).find('.modal-body').html(value.message);
        		});
        	} else {
        		$(bookModal).find('.modal-body').html('An unknown error occurred. Please contact Administrator.');
        	}
        })
        .catch(error => {
            console.log('Request failed', error);
            $(bookModal).find('.modal-body').html('An unknown error occurred. Please contact Administrator.');
		});
}

function clearModal(modal) {
	$(modal).find(modalTitle).html('');
    $(modal).find(modalBody).html('');
    $(modal).find(modalFooter).html('');
}

$(document).ready(() => {
	$('#bookModal').on('show.bs.modal', function(event) {
		  var bookModal = $(this);
		  var button = $(event.relatedTarget);
		  var bookAction = button.data('book-action');
		  var bookId = button.data('book-id');
		  
		  switch(bookAction) {
		  	case 'addBook':
		  		addBook(bookModal);
		  		break;
		  		
			case 'viewBook':
		  		viewBook(this, bookId);
		  		break;
		  }
	}).on('hidden.bs.modal', function(event) {
        clearModal(this);
	});
});