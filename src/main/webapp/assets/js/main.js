$(document).ready(() => {
	$('#bookModal').modal({
        keyboard: true,
        backdrop: "static",
        show: false,
	}).on('show.bs.modal', (event) => {
		  var bookModal = $(this);
		  var button = $(event.relatedTarget);
		  var bookAction = button.data('action');
		  var bookId = button.data('id');
		  
		  switch(bookAction) {
		  	case 'addBook':
		  		addBook(bookModal);
		  		break;
		  		
		  	case 'viewBook':
		  		viewBook(bookModal, bookId);
		  		break;
		  		
		  	case 'editBook':
		  		editBook(bookModal, bookId);
		  		break;
		  		
		  	case 'deleteBook':
		  		deleteBook(bookModal, bookId);
		  		break;
		  }
	}).on('hidden.bs.modal', (event) => {
        $(this).find('.modal-title').html('');
        $(this).find('.modal-body').html('');
        $(this).find('.modal-footer').html('');
	});
	
	let modalTitle = $('.modal-title');
	let modalBody = $('.modal-body');
	
	function addBook(bookModal) {
		
	}
	
	function viewBook(bookModal, bookId) {
		console.log(bookModal);
		$(bookModal).find(modalTitle).html('View Book');
		$(bookModal).find(modalBody).html(`<h2>${bookId}</h2>`);
	}
	
	function editBook(bookModal, bookId) {
		
	}
	
	function deleteBook(bookModal, bookId) {
		
	}
});