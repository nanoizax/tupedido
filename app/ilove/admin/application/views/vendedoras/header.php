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
      <div style="margin-left: 3%; margin-right: 3%;" class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Clientes
          
        </div><a href="<?= base_url()?>usuario/crear_vendedor" class="btn btn-primary">Nuevo Vendedor</a>
        <div class="card-body">
          <div class="table-responsive">
              
              <table id="example" class="display nowrap" style="width:100%">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Tipo - Vendedor</th>
                  <th>Nombres</th>
                  <th>Apellidos</th>
                  <th>DNI</th>
                  <th>Correo</th>
                  <th>Telefono</th>
                  <th>Ciudad</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>ID</th>
                  <th>Nombres</th>
                  <th>Apellidos</th>
                  <th>DNI</th>
                  <th>Correo</th>
                  <th>Telefono</th>
                  <th>Ciudad</th>
                </tr>
              </tfoot>
              <tbody>
                <?php
                  foreach ($consulta->result() as $fila) { 
                ?>

                <tr>
                  <td><?= $fila->id ?></td>
                  <td><?= $fila->id_tipo_vendedor ?></td>
                  <td><?= $fila->nombres ?></td>
                  <td><?= $fila->apellidos ?></td>
                  <td><?= $fila->DNI ?></td>
                  <td><?= $fila->correo ?></td>
                  <td><?= $fila->telefono ?></td>
                  <td><?= $fila->ciudad ?></td>
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