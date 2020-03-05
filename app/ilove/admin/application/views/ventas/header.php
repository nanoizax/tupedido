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
          <i class="fa fa-table"></i> Ventas
          
        </div>
        <div class="card-body">
          <div class="table-responsive">
                            
              <table id="example" class="display nowrap" style="width:100%">
              <thead>
                <tr>
                  <th>Cliente</th>  
                  <th>Imagen</th>
                  <th>Nombre</th>
                  <th>Cantidad</th> 
                  <th>Pago</th>                 
                  <th>Fecha</th>
                  <th>Datos Cliente</th>
                  <th>Ver Venta</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Cliente</th>  
                  <th>Imagen</th>
                  <th>Nombre</th>
                  <th>Cantidad</th> 
                  <th>Pago</th>                 
                  <th>Fecha</th>
                  <th>Datos Cliente</th>
                  <th>Ver Venta</th>
                </tr>
              </tfoot>
              <tbody>
                <?php
                  foreach ($consulta->result() as $fila) { 
                    $id= 0;
                ?>

                <tr id="<?php $id ?>">
                  <td><?= $fila->nombres ?></td>
                  <td>
                    <img width="75px" height="75px" src="<?= $fila->img ?>">
                  </td>
                  <td><?= $fila->nombre ?></td>
                  <td><?= $fila->cantidad ?></td>
                  <td><?= $fila->pago ?></td>
                  <td><?= $fila->log ?></td>
                  <th><a href="<?= base_url()?>usuario/cliente_view/<?= $fila->id ?>" class="btn btn-success">Datos Cliente</a></th>
                  <th><a href="<?= base_url()?>usuario/venta_view/<?= $fila->id_venta ?>" class="btn btn-success">Ver Venta</a></th>
                  
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

