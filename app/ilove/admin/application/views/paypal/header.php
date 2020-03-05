<div class="content-wrapper">
  <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">

        <!-- Example DataTables Card-->
      <div style="margin-left: 3%;margin-right: 3%;" class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Registro Paypal
          
        </div>

        <div class="card-body">
          <div class="table-responsive">
                            
              <table id="example" class="display nowrap" style="width:100%">
              <thead>
                <tr>
                  <th>Code Compra</th>
                  <th>Code Paypal</th>
                  <th>Fecha</th>                  
                  <th>Ver venta</th> 
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Code Compra</th>
                  <th>Code Paypal</th>
                  <th>Fecha</th>                  
                  <th>Ver venta</th>
                </tr>
              </tfoot>
              <tbody>
                <?php
                  foreach ($consulta->result() as $fila) { 
                ?>

                <tr>
                  <td><?= $fila->id_compra ?></td>
                  <td><?= $fila->code ?></td>
                  <td><?= $fila->log ?></td>
                  <th><a href="<?= base_url()?>usuario/venta_view/<?= $fila->id_compra ?>" class="btn btn-success">Ver Venta</a></th>
                </tr>

                <?php } ?>
                
              </tbody>
            </table>
              
            
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    </div>



    </div>
     
  </div>
</div>