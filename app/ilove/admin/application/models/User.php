<?php 

	/**
	 * 
	 */
	class User extends CI_Model
	{
		
		public function getUser($email = '')
		{
			
			$result = $this->db->query("SELECT * FROM usuarios WHERE Usuario = '".$email."' LIMIT 1");

			if($result->num_rows() > 0){

				return $result -> row();

			}else{
				return null;
			}

		}

		public function getUserTipo($email = '')
		{
			
			$result = $this->db->query("SELECT * FROM administradores WHERE correo = '".$email."' LIMIT 1");

			if($result->num_rows() > 0){

				return $result -> row();

			}else{
				
				$result = $this->db->query("SELECT * FROM vendedores WHERE correo = '".$email."' LIMIT 1");

				return $result -> row();
			}

		}

		

	}

?>