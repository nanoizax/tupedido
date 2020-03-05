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
          <i class="fa fa-table"></i> Data Table Example</div>
        <div class="card-body">
          <div class="table-responsive">
              
              <?php 

              $var = $this->session->userdata('id');

              if($var == "1")
              {

              ?>
              
            <table id="example" class="display nowrap" style="width:100%">
              <thead>
                <tr>
                  <th>Vendedora</th>
                  <th>Cliente</th>
                  <th>Estado</th>
                  <th>Inicio LLamada</th>
                  <th>Fin Llamada</th>
                  
                  <th>Fecha</th>
                  <th>Nota</th>
                  <th>Programada</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Vendedora</th>
                  <th>Cliente</th>
                  <th>Estado</th>
                  <th>Inicio LLamada</th>
                  <th>Fin Llamada</th>
                  
                  <th>Fecha</th>
                  <th>Nota</th>
                  <th>Programada</th>
                </tr>
              </tfoot>
              <tbody>
                  
                <?php
                  foreach ($consulta->result() as $fila) { 
                ?>

                <tr>
                  <td><?= $fila->vendedora ?></td>
                  <td><?= $fila->nombres ?></td>
                  <td><?= $fila->estado ?></td>
                  <td><?= $fila->tiempo_llamada ?></td>
                  <td><?= $fila->tiempo_llamada_fin ?></td>
                  
                  <td><?= $fila->fecha ?></td>
                  <td><?= $fila->nota ?></td>
                  <td><?= $fila->programada ?></td>
                  
                </tr>

                <?php } ?>
                
              </tbody>
            </table>
            
             <?php 

              }else{

             ?>
             
             <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Cliente</th>
                  <th>Estado</th>
                  <th>Inicio LLamada</th>
                  <th>Fin Llamada</th>
                  
                  <th>Fecha</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Cliente</th>
                  <th>Estado</th>
                  <th>Inicio LLamada</th>
                  <th>Fin Llamada</th>
                  
                  <th>Fecha</th>
                </tr>
              </tfoot>
              <tbody>
                  
                <?php
                  foreach ($consulta->result() as $fila) { 
                ?>

                <tr>
                  <td><?= $fila->nombres ?></td>
                  <td><?= $fila->estado ?></td>
                  <td><?= $fila->tiempo_llamada ?></td>
                  <td><?= $fila->tiempo_llamada_fin ?></td>
                  
                  <td><?= $fila->fecha ?></td>
                </tr>

                <?php } ?>
                
              </tbody>
            </table>
             
             <?php } ?>
        
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    </div>



    </div>
     
  </div>
</div>