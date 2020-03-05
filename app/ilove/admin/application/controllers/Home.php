<?php 

/**
 * 
 */
class Home extends CI_Controller
{
	
	public function index($info = '')
	{
		//$this->session->sess_destroy();

		$data = array('title' => 'Login', 'mensaje' => 'Hola mundo con framework');		
		$this->load->view("/global/head", $data);

		$data = array('post' => 'Blog', 'descripcion' => 'Bienvenidos a mi pagina');
		$this->load->view("/login/content", $data);

		
	}

}