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
          <i class="fa fa-table"></i> Categorias
          
        </div>
        <a href="<?= base_url()?>usuario/crear_categoria" class="btn btn-primary">Nueva categoria</a>
        <div class="card-body">
          <div class="table-responsive">
                            
              <table id="example" class="display nowrap" style="width:100%">
              <thead>
                <tr>
                  <th>Nombre</th>
                  <th>Creada el</th>
                  <th>Modificar</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Nombre</th>
                  <th>Creada el</th>
                  <th>Modificar</th>
                  <th>Eliminar</th>
                </tr>
              </tfoot>
              <tbody>
                <?php
                  foreach ($consulta->result() as $fila) { 
                ?>

                <tr>
                  <td><?= $fila->nombre ?></td>
                  <td><?= $fila->log ?></td>
                  <th><a href="<?= base_url()?>usuario/categorias_update/<?= $fila->id ?>" class="btn btn-primary">Modificar</a></th>
                  <th><a href="<?= base_url()?>usuario/delete_categoria/<?= $fila->id ?>" class="btn btn-warning">Eliminar</a></th>
                  
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