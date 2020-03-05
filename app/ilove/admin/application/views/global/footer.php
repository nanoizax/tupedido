   
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright &copy; Developer Wolf 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>

   <!-- Bootstrap core JavaScript-->
    <script src="<?= base_url() ?>plantilla/vendor/jquery/jquery.min.js"></script>
    <script src="<?= base_url() ?>plantilla/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="<?= base_url() ?>plantilla/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="<?= base_url() ?>plantilla/vendor/chart.js/Chart.min.js"></script>

    <!-- <script src="<?= base_url() ?>plantilla/vendor/datatables/jquery.dataTables.js"></script>-->
    <!--<script src="<?= base_url() ?>plantilla/vendor/datatables/dataTables.bootstrap4.js"></script>-->
    <!-- Custom scripts for all pages-->
    <!--<script src="<?= base_url() ?>plantilla/js/sb-admin.min.js"></script>-->
    <!-- Custom scripts for this page-->
    <!--<script src="<?= base_url() ?>plantilla/js/sb-admin-datatables.min.js"></script>-->
    <!--<script src="<?= base_url() ?>plantilla/js/sb-admin-charts.min.js"></script> -->

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>
    
    <script>
      
    $(document).ready(function() {
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
        } );
    } );

    </script>
    


  </body>

</html>