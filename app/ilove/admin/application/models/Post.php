<?php 

	/**
	 * 
	 */
	class Post extends CI_Model
	{
		
		public function getClientes($id = '')
		{
			
			$result = $this->db->query("SELECT * FROM ilove_user WHERE id = '".$id."' LIMIT 1");
			return $result->row();

		}
		
		public function getSliderAll()
		{
			
			return $this->db->query("SELECT * FROM ilove_pager_home ORDER BY id DESC");

		}
		
		public function getSliderPrincipal($id = '')
		{
			
			$result = $this->db->query("SELECT * FROM ilove_pager_home WHERE id = '".$id."' LIMIT 1");
			return $result->row();

		}
		
		public function getPostByName($id = '')
		{
			
			$result = $this->db->query("SELECT * FROM usuarios WHERE id = '".$id."' LIMIT 1");
			return $result->row();

		}

		public function getArticulotById($id = '')
		{
			
			$result = $this->db->query("SELECT * FROM ilove_producto WHERE id = '".$id."' LIMIT 1");
			return $result->row();

		}

		public function getRecetaById($id = '')
		{
			
			$result = $this->db->query("SELECT * FROM recetas WHERE id = '".$id."' LIMIT 1");
			return $result->row();

		}

		public function getVendedoras($id = '')
		{
			
			$result = $this->db->query("SELECT * FROM vendedores WHERE correo = '".$id."' LIMIT 1");
			return $result->row();

		}

		public function getCategorias($id = '')
		{
			
			$result = $this->db->query("SELECT * FROM categorias WHERE id = '".$id."' LIMIT 1");
			return $result->row();

		}

		public function getVentasById($id = '')
		{
			
			$result = $this->db->query("SELECT d.id, u.id AS id_venta, u.id_cliente, d.nombres, v.nombre, v.img, u.cantidad, u.pago, u.log FROM ventas u INNER JOIN clientes d ON d.id = u.id_cliente INNER JOIN productos v ON v.id = u.id_producto WHERE u.id = '".$id."' ORDER BY u.id DESC");
			return $result->row();

		}
		
		public function getLlamadas($id = '')
		{
			
			return $this->db->query("SELECT u.estado, u.fecha, u.tiempo_llamada, u.tiempo_llamada_fin, d.nombres FROM llamadas u INNER JOIN clientes d ON d.id = u.id_cliente WHERE u.id_vendedor = '".$id."' ORDER BY u.id DESC");

		}
		
		//Administrador
		
		public function getClientesAll()
		{
			
			return $this->db->query("SELECT * FROM ilove_user ORDER BY id DESC");

		}

		public function getProductosAll()
		{
			
			return $this->db->get("ilove_producto");

		}

		public function getCategoriasAll()
		{
			
			return $this->db->get("categorias");

		}
		
		public function getVendedorasAll()
		{
			
			return $this->db->get("vendedores");

		}

		public function getPaypalAll()
		{
			
			return $this->db->get("paypal");

		}

		public function getRecetasAll()
		{
			
			return $this->db->query("SELECT u.id, u.id_cliente, u.log, u.ruta, d.nombres FROM recetas u INNER JOIN clientes d ON d.id = u.id_cliente");

		}

		public function getVentasAll()
		{
			
			return $this->db->query("SELECT d.id, u.id AS id_venta, d.nombres, v.nombre, v.img, u.cantidad, u.pago, u.log FROM ventas u INNER JOIN clientes d ON d.id = u.id_cliente INNER JOIN productos v ON v.id = u.id_producto ORDER BY u.id DESC
");

		}
		
		public function getLlamadasAll()
		{
			
			return $this->db->query("SELECT v.nombres AS vendedora, u.estado, u.fecha, u.programada, u.nota, u.tiempo_llamada, u.tiempo_llamada_fin, d.nombres FROM llamadas u INNER JOIN clientes d ON d.id = u.id_cliente INNER JOIN vendedores v ON v.id = d.id_vendedor ORDER BY u.id DESC");

		}

		//----------------------------------

		public function deleteArticulotById($id = '')
		{
			if($id != null){	

				$SQL = "DELETE FROM ilove_producto WHERE id = '".$id."' LIMIT 1";

				if($this->db->query($SQL)){
						return true;
					}else{

					}

			}

			return false;

		}

		public function deleteCategoriatById($id = '')
		{
			if($id != null){	

				$SQL = "DELETE FROM categorias WHERE id = '".$id."' LIMIT 1";

				if($this->db->query($SQL)){
						return true;
					}else{

					}

			}

			return false;

		}

		public function deleteClientetById($id = '')
		{
			if($id != null){	

				$SQL = "DELETE FROM clientes WHERE id = '".$id."' LIMIT 1";

				if($this->db->query($SQL)){
						return true;
					}else{

					}

			}

			return false;

		}

		public function deleteRecetastById($id = '')
		{
			if($id != null){	

				$SQL = "DELETE FROM recetas WHERE id = '".$id."' LIMIT 1";

				if($this->db->query($SQL)){
						return true;
					}else{

					}

			}

			return false;

		}
		
		public function deleteSliderPrincipalById($id = '')
		{
			if($id != null){	

				$SQL = "DELETE FROM ilove_pager_home WHERE id = '".$id."' LIMIT 1";

				if($this->db->query($SQL)){
						return true;
					}else{

					}

			}

			return false;

		}

		//-----------------------------------------------------------------
		public function update_categoria($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);
			
			if($post != null){			
				$nombres = $post['categoria'];
				$id = $post['id'];
				//$file_name = $post['file_name'];

				$SQL = "UPDATE categorias SET nombre = '".$nombres."' WHERE id = '".$id."'";

				if($this->db->query($SQL)){
					return true;
				}else{

				}

			}

			return false;

		}

		public function update_cliente($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);

		    $id_vendedor = "1";
			
			if($post != null){			
				$nombres = $post['nombre'];
				$sexo = $post['sexo'];
				$email = $post['email'];
				$pass = $post['password'];
				$id = $post['id'];
				//$file_name = $post['file_name'];

				$SQL = "UPDATE ilove_user SET nombre = '".$nombres."', sexo = '".$sexo."', email = '".$email."', password = '".$pass."' WHERE id = '".$id."'";

				if($this->db->query($SQL)){
					return true;
				}else{

				}

			}

			return false;

		}

		public function update_producto($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);
			
			if($post != null){			
				$nombres = $post['nombre'];
				$latitud = $post['latitud'];
				$longitud = $post['longitud'];
				$file_name = $post['file_name'];
				$id = $post['id'];

				$SQL = "UPDATE ilove_producto SET img = '".$file_name."', nombre = '".$nombres."', latitud = '".$latitud."', longitud = '".$longitud."' WHERE id = '".$id."'" ;

				if($this->db->query($SQL)){
					return true;
				}else{

				}

			}

			return false;

		}

        //-----------------------------------------------------------------

		public function insert_cliente($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);

		    $id_vendedor = "1";
			
			if($post != null){			
				$nombres = $post['nombres'];
				$telefono = $post['sexo'];
				$email = $post['email'];
				$pass = $post['password'];
				//$file_name = $post['file_name'];

				$SQL = "INSERT INTO ilove_user(nombre, sexo, email, password) VALUES ('".$nombres."','".$telefono."','".$email."','".$pass."')";

				if($this->db->query($SQL)){
					return true;
				}else{

				}

			}

			return false;

		}



		public function insert_producto($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);
			
			if($post != null){			
				$nombres = $post['nombre'];
				$latitud = $post['latitud'];
				$longitud = $post['longitud'];
				$file_name = $post['file_name'];

				$SQL = "INSERT INTO ilove_producto(img, nombre, latitud, longitud) VALUES ('".$file_name."','".$nombres."','".$latitud."','".$longitud."')";

				if($this->db->query($SQL)){
					return true;
				}else{

				}

			}

			return false;

		}
		
		public function insert_slider_principal($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);
			
			if($post != null){			
				
				$file_name = $post['file_name'];

				$SQL = "INSERT INTO ilove_pager_home(img) VALUES ('".$file_name."')";

				if($this->db->query($SQL)){
					return true;
				}else{

				}

			}

			return false;

		}

		public function insert_categoria($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);
			
			if($post != null){			
				$nombres = $post['nombre'];
				//$file_name = $post['file_name'];

				$SQL = "INSERT INTO categorias(nombre) VALUES ('".$nombres."')";

				if($this->db->query($SQL)){
					return true;
				}else{

				}

			}

			return false;

		}
		
		public function insert_vendedora($post = null)
		{
			$this->load->model('user');
		    $var = $this->session->userdata('email');
		    $fila = $this->post->getVendedoras($var);

		    $id_vendedor = $fila->id;
			
			if($post != null){	
			    $tipo = $post['tipo'];
				$nombres = $post['nombres'];
				$apellidos = $post['apellidos'];
				$DNI = $post['DNI'];
				$correo = $post['correo'];
				$telefono = $post['telefono'];
				$ciudad = $post['ciudad'];
				
				//$file_name = $post['file_name'];

				$SQL = "INSERT INTO vendedores(id_tipo_vendedor, nombres, apellidos, DNI, correo, telefono, ciudad) VALUES ('".$tipo."','".$nombres."','".$apellidos."','".$DNI."','".$correo."','".$telefono."','".$ciudad."')";

				if($this->db->query($SQL)){
					$SQL2 = "INSERT INTO usuarios(nombre, email, password, tipo_usuario) VALUES ('".$nombres."','".$correo."','".$DNI."', '0')";

    				if($this->db->query($SQL2)){
    					return true;
    				}else{
    
    				}
				}else{

				}
				
				

			}

			return false;

		}

	}

?>