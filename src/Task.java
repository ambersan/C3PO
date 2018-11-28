
public class Task 
{
	//the text shown on screen and checked value
		private String label;
		private boolean isSelected = false;
	 
		//setter for text value
		public Task()
		{
			this.label = null;
		}
		
		public void setDescription(String label) 
		{
			this.label = label;
		}
		
		//getter for text value 
		public String toString() 
		{
			return label;
		}
		
		//setter for selected value
		public void setSelected(boolean isSelected) 
		{
			this.isSelected = isSelected;
		}
		
		//getter for selected value
		public boolean isSelected() 
		{
			return isSelected;
		}
}
