<?php 

require_once APPPATH.'/third_party/Spout/Autoloader/autoload.php';

 use Box\Spout\Reader\ReaderFactory;  
 use Box\Spout\Common\Type;
/**
 * 
 */
class Usuario extends CI_Controller
{
	
	public function index($info = '')
	{
		//$this->session->sess_destroy();

		$this->load->model('user');
		$var = $this->session->userdata('email');
		//$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => "Ilove", 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		$data = array('post' => 'Blog', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/header", $data);

		$this->load->view("/global/footer", $data);
		
	}
	
	public function slider_principal($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		$fila = $this->post->getVendedoras($var);
		
		//Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');
  
            $result = $this->post->getSliderAll();
            
            $data = array('consulta' => $result);
        

		$this->load->view("/slider_principal/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}
	
	public function slider_principal_view($id = '')
	{

		$fila = $this->post->getSliderPrincipal($id);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//-------------------------------------------

		$data = array(
			'img'=> $fila->img);

		$this->load->view("/slider_principal/view", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}
	
	public function crear_slider_principal($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
	

		$this->load->view("/slider_principal/new", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}
	
	public function insertSliderPrincipal(){

		$post = $this->input->post();

		$this->load->model('file');

		$file_name = $this->file->UploadImage('./public/img/', 'No es posible subir imagen...');

		$ruta = "http://devsizax.com/proyectos/ilove/admin/public/img/";

		$post['file_name'] = $ruta.$file_name;
	
		$bool = $this->post->insert_slider_principal($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/slider_principal");
		}else{
			header("Location: ".base_url()."usuario/crear_slider_principal");
		}

	}
	
	public function delete_slider_principal($id = ''){

		$bool = $this->post->deleteSliderPrincipalById($id);

		if($bool == true){
			header("Location: ".base_url()."usuario/slider_principal");
		}else{
			header("Location: ".base_url()."usuario/index");
		}

	}

	public function clientes($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		$fila = $this->post->getVendedoras($var);
		
		//Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');
  
            $result = $this->post->getClientesAll();
            
            $data = array('consulta' => $result);
        

		$this->load->view("/clientes/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function productos($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');
  
            $result = $this->post->getProductosAll();
            
            $data = array('consulta' => $result);
        
		$this->load->view("/productos/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function recetas($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');
  
            $result = $this->post->getRecetasAll();
            
            $data = array('consulta' => $result);
        
		$this->load->view("/recetas/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function paypal($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//Validar si es administrador ----------
        
            $result = $this->post->getPaypalAll();
            
            $data = array('consulta' => $result);
        
		$this->load->view("/paypal/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function ventas($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//Validar si es administrador ----------
        
            $result = $this->post->getVentasAll();
            
            $data = array('consulta' => $result);
        
		$this->load->view("/ventas/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function categorias($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');
  
            $result = $this->post->getCategoriasAll();
            
            $data = array('consulta' => $result);
        
		$this->load->view("/categorias/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function articulo($id = '')
	{

		$fila = $this->post->getArticulotById($id);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//-------------------------------------------

		$data = array(
			'nombre'=> $fila->nombre, 
			'img' => $fila->img,
			'latitud' => $fila->latitud,
			'longitud' => $fila->longitud);

		$this->load->view("/productos/view", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function venta_view($id = '')
	{

		$fila = $this->post->getVentasById($id);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//-------------------------------------------

		$data = array(
			'id' => $fila->id_cliente,
			'nombre'=> $fila->nombres, 
			'img' => $fila->img,
			'producto' => $fila->nombre,
			'pago' => $fila->pago,
			'cantidad' => $fila->cantidad,
			'fecha' => $fila->log);

		$this->load->view("/ventas/view", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}


	public function receta_view($id = '', $nombre = '')
	{

		$fila = $this->post->getRecetaById($id);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//-------------------------------------------

		$data = array(
			'fecha'=> $fila->log, 
			'img' => $fila->ruta,
			'id' => $fila->id_cliente,
			'nombre' => $nombre);

		$this->load->view("/recetas/view", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function cliente_view($id = '')
	{

		$fila = $this->post->getClientes($id);

		$data = array('title' => '', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
		
		//-------------------------------------------

		$data = array(
			'nombre'=> $fila->nombre, 
			'email' => $fila->email,
			'sexo' => $fila->sexo,
			'password' => $fila->password);

		$this->load->view("/clientes/view", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}
	
	public function historias($info = '')
	{
	    $data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		//Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');
		
		$this->load->view("/historias/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}
	
	public function vendedoras($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		$fila = $this->post->getVendedoras($var);
		
		//Validar si es administrador ----------
        
		    $result = $this->post->getVendedorasAll();
            
            $data = array('consulta' => $result);
            
		$this->load->view("/vendedoras/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function llamadas($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

        //Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');

        if($var_tipo == "1")
        {
            
            $result = $this->post->getLlamadasAll();
            
            $data = array('consulta' => $result);
            
        }else{
            
            $fila = $this->post->getVendedoras($var);

		    $result = $this->post->getLlamadas($fila->id);
            
            $data = array('consulta' => $result);
            
        }

		$this->load->view("/llamadas/header", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function crear_cliente($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
	

		$this->load->view("/clientes/new", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}
	
	public function categorias_update($id = '')
	{
		
		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		$fila = $this->post->getCategorias($id);

		$data = array(
			'nombre'=> $fila->nombre, 
			'id' => $fila->id);
		
		$this->load->view("/categorias/update", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function clientes_update($id = '')
	{
		
		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		$fila = $this->post->getClientes($id);

		$data = array(
			'nombre'=> $fila->nombre,
			'sexo' => $fila->sexo,
			'email' => $fila->email,
			'password' => $fila->password,
			'id' => $fila->id);
		
		$this->load->view("/clientes/update", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function producto_update($id = '')
	{
		
		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		$fila = $this->post->getArticulotById($id);

		$data = array(
			'nombre'=> $fila->nombre,
			'latitud' => $fila->latitud,
			'longitud' => $fila->longitud,
			'img' => $fila->img,
			'id' => $fila->id);
		
		$this->load->view("/productos/update", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function updateProducto($id = ''){

		$post = $this->input->post();

		$this->load->model('file');

		$file_name = $this->file->UploadImage('./public/img/', 'No es posible subir imagen...');

		$ruta = "http://devsizax.com/proyectos/ilove/admin/public/img/";

		$post['file_name'] = $ruta.$file_name;

		$post['id'] = $id;
	
		$bool = $this->post->update_producto($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/productos");
		}else{
			header("Location: ".base_url()."usuario/crear_producto");
		}

	}

	public function crear_producto($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
	

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/productos/new", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function crear_categoria($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);
	

		$this->load->view("/categorias/new", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}
	
	public function crear_vendedor($info = '')
	{
		$this->load->model('user');
		$var = $this->session->userdata('email');
		$fila = $this->user->getUserTipo($var);

		$data = array('title' => 'Usuario', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('app' => 'Ilove', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/global/nav", $data);

		 //Validar si es administrador ----------
        
        $var_tipo = $this->session->userdata('id');

        if($var_tipo == "1")
        {
            
            $result = $this->post->getLlamadasAll();
            
            $data = array('consulta' => $result);
            
        }else{
            
            $fila = $this->post->getVendedoras($var);

		    $result = $this->post->getLlamadas($fila->id);
            
            $data = array('consulta' => $result);
            
        }

		$this->load->view("/vendedoras/new", $data);
		
		//------------------------------------------

		$this->load->view("/global/footer", $data);
		
	}

	public function updateCategoria($id = ''){

		$post = $this->input->post();

		$post['id'] = $id;
	
		$bool = $this->post->update_categoria($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/categorias");
		}else{
			header("Location: ".base_url()."usuario/crear_cliente");
		}

	}

	public function updateCliente($id = ''){

		$post = $this->input->post();

		$post['id'] = $id;
	
		$bool = $this->post->update_cliente($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/clientes");
		}else{
			header("Location: ".base_url()."usuario/crear_cliente");
		}

	}

	public function insert(){

		$post = $this->input->post();
	
		$bool = $this->post->insert_cliente($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/clientes");
		}else{
			header("Location: ".base_url()."usuario/crear_cliente");
		}

	}

	public function insertProducto(){

		$post = $this->input->post();

		$this->load->model('file');

		$file_name = $this->file->UploadImage('./public/img/', 'No es posible subir imagen...');

		$ruta = "http://devsizax.com/proyectos/ilove/admin/public/img/";

		$post['file_name'] = $ruta.$file_name;
	
		$bool = $this->post->insert_producto($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/productos");
		}else{
			header("Location: ".base_url()."usuario/crear_producto");
		}

	}

	public function insertCategoria(){

		$post = $this->input->post();
	
		$bool = $this->post->insert_categoria($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/categorias");
		}else{
			header("Location: ".base_url()."usuario/crear_categoria");
		}

	}
	
	public function insert_vendedora(){

		$post = $this->input->post();
	
		$bool = $this->post->insert_vendedora($post);

		if($bool == true){
			header("Location: ".base_url()."usuario/vendedoras");
		}else{
			header("Location: ".base_url()."usuario/crear_vendedor");
		}

	}

	public function delete_producto($id = ''){

		$bool = $this->post->deleteArticulotById($id);

		if($bool == true){
			header("Location: ".base_url()."usuario/productos");
		}else{
			header("Location: ".base_url()."usuario/index");
		}

	}

	public function delete_categoria($id = ''){

		$bool = $this->post->deleteCategoriatById($id);

		if($bool == true){
			header("Location: ".base_url()."usuario/categorias");
		}else{
			header("Location: ".base_url()."usuario/index");
		}

	}

	public function delete_cliente($id = ''){

		$bool = $this->post->deleteClientetById($id);

		if($bool == true){
			header("Location: ".base_url()."usuario/clientes");
		}else{
			header("Location: ".base_url()."usuario/index");
		}

	}

	public function delete_receta($id = ''){

		$bool = $this->post->deleteRecetastById($id);

		if($bool == true){
			header("Location: ".base_url()."usuario/recetas");
		}else{
			header("Location: ".base_url()."usuario/index");
		}

	}
	
	//-------------------------------
	
	public function guardar_horario(){
    
    
         if (!empty($_FILES['file']['name'])) {
        
        
          $pathinfo = pathinfo($_FILES["file"]["name"]);
        
        
           if (($pathinfo['extension'] == 'xlsx' || $pathinfo['extension'] == 'xls') 
               && $_FILES['file']['size'] > 0 ) {
        
            // Nombre Temporal del Archivo
            $inputFileName = $_FILES['file']['tmp_name']; 
        
            //Lee el Archivo usando ReaderFactory
            $reader = ReaderFactory::create(Type::XLSX);
        
            //Esta linea mantiene el formato de nuestras horas y fechas
            //Sin esta linea Spout convierte la hora y fecha a su propio formato
            //predefinido como DataTime
        
            $reader->setShouldFormatDates(true);
        
            // Abrimos el archivo
            $reader->open($inputFileName);
            $count = 1;
        
            //Numero de Hojas en el Archivo
            foreach ($reader->getSheetIterator() as $sheet) {
        
                // Numero de filas en el documento EXCEL
                foreach ($sheet->getRowIterator() as $row) {
        
                    // Lee los Datos despues del encabezado
                    // El encabezado se encuentra en la primera fila
                 if($count > 1) {
        
        
                    $data = array(
        
                      //rut_usu, fecha_ini, y fecha_ter son imputs del formulario
                      //no se encuentran en el archivo EXCEL
                      //los estoy capturando por POST
        
                      'id_vendedor' => $row[0],
                      'nombres' => $row[1],
                      'apellidos' => $row[2],
                      'DNI' => $row[3],
                      'correo' => $row[4],
                      'telefono' => $row[5],
                      'ciudad' => $row[6],

                   ); 
        
        
                  $this->db->insert('clientes',$data);
        
                  } 
                    $count++;
                 }
             }
        
             // cerramos el archivo EXCEL
              $reader->close();
              header("Location: ".base_url()."usuario/vendedoras");
        
           } else {
        
            echo "Seleccione un tipo de Archivo Valido";
           }
        
         } else {
        
         echo "Seleccione un Archivo EXCEL";
        
          }


     }


}