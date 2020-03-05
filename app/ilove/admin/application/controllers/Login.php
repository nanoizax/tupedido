<?php 

/**
 * 
 */
class Login extends CI_Controller
{
	
	public function index()
	{
		
		$email = $this->input->post('email');
		$password = $this->input->post('password');

		$this->load->model('user');
		$fila = $this->user->getUser($email);

		if($fila != null){
			if($fila->password == $password){

				$data = array(

				'email' => $email,
				'id' => $fila->tipo_usuario,
				'login' => true

				);

				$this->session->set_userdata($data);

				header("Location:" . base_url()."usuario");

			}else{

				header("Location:" . base_url()."home");

			}
		}else{

			header("Location:" . base_url()."home");

		}
		
	}

	public function logout(){

		$this->session->sess_destroy();
		header("Location: ".base_url()."home");

	}

}