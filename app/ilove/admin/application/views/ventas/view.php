<div class="container" style="margin-top: 5%; margin-bottom: 4%; margin-left: 15%">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">

            <h1><?= $nombre ?></h1>

            <img width="300px" height="200px" src="<?= $img ?>">

            <h4>Producto: <?= $producto ?></h4>

            <h4>Cantidad: <?= $cantidad ?></h4>

            <h4>Pago: <?= $pago ?></h4>

            <h4>Fecha: <?= $fecha ?></h4>

            <a href="<?= base_url()?>usuario/cliente_view/<?= $id ?>" class="btn btn-success">Datos Cliente</a>

        </div>
      </div>
    </div>

    <hr>
