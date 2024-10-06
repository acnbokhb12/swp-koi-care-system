<%-- 
    Document   : manageCategory
    Created on : Oct 7, 2024, 12:15:00 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manage Categories</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <!-- font awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Jquery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- css -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminCategory.css">
    </head>

    <body>

        <div class="container_admin">
            <div id="db-wrapper">
                <!-- start-sidebar -->
                <div id="sidebar_admin"></div>
                <!-- start header -->
                <header id="header"></header>
                <!-- right -->
                <div class="right-navbar-admin-manage">
                    <!-- Main Content Section -->
                    <div class="content">
                        <!-- Header with actions -->
                        <div class="header">
                            <h2>Category List</h2>
                            <div class="actions">
                                <button id="createNewCategory">Create New Category</button>
                            </div>
                        </div>
                        <!-- Category Table -->
                        <div class="table-container" id="categoryTableContainer">
                            <table id="categoryTable">
                                <thead>
                                    <tr>
                                        <th>Category ID</th>
                                        <th>Category Name</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>#CAT001</td>
                                        <td>Food</td>
                                        <td>
                                            <div class="actions">
                                                <button class="edit-btn">
                                                    <i class="fas fa-edit"></i> Edit
                                                </button>
                                                <button class="delete-btn">
                                                    <i class="fas fa-trash"></i> Remove
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <!-- Footer and Pagination -->
                            <div class="footer">
                                <div class="pagination">
                                    <button><a href="" class="text-dark">Previous</a></button>
                                    <button><a href="" class="text-dark">1</a></button>
                                    <button><a href="" class="text-dark">Next</a></button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="container_main-add" style="display: none;">
            <div class="contain_add-detail">
                <form action="your-action-url-here" method="POST" id="form_fill-add">
                    <div class="row row-add-detail">
                        <div class="col-12 edit-info">
                            <div class="text-right">
                                <button type="button" class="btn-close-add" aria-label="Close">
                                    <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                                </button>
                            </div>
                            <h2 class="text-center">Create New Category</h2>
                            <div class="row row-edit-info-detail">
                                <div class="col-md-12 add-item-detail">
                                    <label for="categoryName">Category Name:</label>
                                    <input id="categoryName" name="categoryName" type="text" placeholder="Enter category name" required />
                                </div>
                            </div>
                            <div class="text-center mt-3">
                                <button type="submit" class="add-btn-utils blue-btn">
                                    Confirm
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="container_main-edit" style="display: none;">
            <div class="contain_edit-detail">
                <form action="your-action-url-here" method="POST" id="form_fill-edit">
                    <div class="row row-edit-detail">
                        <div class="col-12 edit-info">
                            <div class="text-right">
                                <button type="button" class="btn-close-edit">
                                    <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                                </button>
                            </div>
                            <h2 class="text-center">Edit Category</h2>
                            <div class="row row-edit-info-detail">
                                <div class="col-md-12 edit-item-detail">
                                    <label for="categoryID">Category ID:</label>
                                    <input id="editCategoryID" name="categoryID" type="text" value="123" readonly />
                                </div>
                                <div class="col-md-12 edit-item-detail">
                                    <label for="categoryName">Category Name:</label>
                                    <input id="editCategoryName" name="categoryName" type="text" placeholder="Enter category name" required />
                                </div>
                            </div>
                            <div class="text-center mt-3">
                                <button type="submit" class="edit-btn-utils blue-btn">
                                    Confirm
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <script>
            $('#header').load('utils.jsp #header_admin', () => {
                $.getScript('./assets/js/utilsAdmin.js');
            });
            $('#sidebar_admin').load('utils.jsp #sidebar_manager');

            // Add category form submission confirmation
            const formAddCategory = document.getElementById('form_fill-add');
            formAddCategory.addEventListener('submit', (e) => {
                const isConfirmed = confirm('Are you sure you want to submit this category?');
                if (!isConfirmed) {
                    e.preventDefault();
                }
            });

            // Open the add category modal
            const btnCreateCat = document.getElementById('createNewCategory');
            const containerAdd = document.querySelector('.container_main-add');
            const closeContainerAdd = document.querySelector('.btn-close-add');

            btnCreateCat.addEventListener('click', (e) => {
                containerAdd.style.display = 'block';
                e.stopPropagation();
            });
            closeContainerAdd.addEventListener('click', () => {
                containerAdd.style.display = 'none';
            });

            // Open the edit category modal
            const containerEdit = document.querySelector('.container_main-edit');
            const closeContainerEdit = document.querySelector('.btn-close-edit');

            document.querySelectorAll('.edit-btn').forEach(button => {
                button.addEventListener('click', (e) => {
                    const categoryID = e.target.closest('button').getAttribute('data-category-id');
                    const categoryName = e.target.closest('button').getAttribute('data-category-name');
                    document.getElementById('editCategoryID').value = categoryID;
                    document.getElementById('editCategoryName').value = categoryName;
                    containerEdit.style.display = 'block';
                    e.stopPropagation();
                });
            });

            closeContainerEdit.addEventListener('click', () => {
                containerEdit.style.display = 'none';
            });

            // Close modals on document click
            document.addEventListener('click', () => {
                containerAdd.style.display = 'none';
                containerEdit.style.display = 'none';
            });
        </script>
    </body>
</html>