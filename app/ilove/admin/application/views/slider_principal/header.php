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
          <i class="fa fa-table"></i> Slider Principal
          
        </div><a href="<?= base_url()?>usuario/crear_slider_principal" class="btn btn-primary">Nueva Imagen</a>
        <div class="card-body">
          <div class="table-responsive">
                            
              <table id="example" class="display nowrap" style="width:100%">
              <thead>
                <tr>
                  <th>Imagen</th>
                  <th>Ver</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Imagen</th>
                  <th>Ver</th>
                  <th>Eliminar</th>
                </tr>
              </tfoot>
              <tbody>
                <?php
                  foreach ($consulta->result() as $fila) { 
                    $id= 0;
                ?>

                <tr id="<?php $id ?>">
                  <td>
                    <img width="75px" height="75px" src="<?= $fila->img ?>">
                  </td>
                  <th><a class="btn btn-success" href="<?= base_url()?>usuario/slider_principal_view/<?= $fila->id ?>">Ver</a></th>
                  <th><a href="<?= base_url()?>usuario/delete_slider_principal/<?= $fila->id ?>" class="btn btn-warning" >Eliminar</a></th>
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

