window.onload = async function () {
    const response = await fetch("/api/", {
        method: "GET", headers: {"Accept": "application/json"}
    });
    if (response.ok) {
        let list = await response.json();
        for (let book of list) {
            console.log(book);
            add_book(book);
        }

        $(".remove").click(async (event) => {
            const response = await fetch(`/api/remove/${event.target.id}`, {
                method: "POST", headers: {"Accept": "application/json"}
            });
            if (response.ok) {
                window.location.href = '/';
            }
        });

        $(".update").click(async (event) => {
            await fetch(`/api/update/${event.target.id}`, {
                method: "POST", headers: {"Accept": "application/json"}
            });
        });
    }

    function add_book(book) {
        let books = document.getElementById("books");
        let child = document.createElement("div")
        child.innerHTML += `<input type="checkbox" class="update" id="${book.id}" ${book.bought ? 'checked' : ''} value="${book.bought}">`
        child.innerHTML += `${book.name} | `;
        child.innerHTML += `${book.genre} | `;
        child.innerHTML += `${book.took} | `;
        child.innerHTML += `${book.returned} `;
        child.innerHTML += `<input type="button" class="remove" id="${book.id}" value="remove">`;
        child.innerHTML += `<button type="button" onclick="window.location.href = '/change/${book.id}'">change</button>`;
        books.appendChild(child);
    }
};