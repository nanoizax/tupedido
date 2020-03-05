<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html"><?= $app ?></a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        
        <!-- ------------------------------------------ -->

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="<?= base_url()?>usuario">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Inicio</span>
          </a>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="<?= base_url()?>usuario/slider_principal">
            <i class="fa fa-phone"></i>
            <span class="nav-link-text">Slider Principal</span>
          </a>
        </li>
     
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="<?= base_url()?>usuario/categorias">
            <i class="fa fa-phone"></i>
            <span class="nav-link-text">Categorias</span>
          </a>
        </li>

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="<?= base_url()?>usuario/productos">
            <i class="fa fa-phone"></i>
            <span class="nav-link-text">Productos</span>
          </a>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="<?= base_url()?>usuario/clientes/">
            <i class="fa fa-phone"></i>
            <span class="nav-link-text">Clientes</span>
          </a>
        </li>
        
   

        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
          <a class="nav-link" href="<?= base_url()?>usuario/ventas">
            <i class="fa fa-phone"></i>
            <span class="nav-link-text">Ventas</span>
          </a>
        </li>

    

          
       

      </ul>

      <!-- ------------------------------------------ -->
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
    
        <li class="nav-item">
          <a class="nav-link"  href="<?= base_url()?>login/logout/">
            <i class="fa fa-fw fa-sign-out"></i>
            Cerrar Session
          </a>
        </li>
      </ul>
    </div>
  </nav>