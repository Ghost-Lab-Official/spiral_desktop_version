package server.Server.Model;

import java.io.Serializable;

public class PopularSearch implements Serializable  {


        private String searched;
        public PopularSearch() { }
        public String getSearch() {
            return searched;
        }
        public void setSearched(String searchQuery){
            this.searched = searchQuery;
        }



}
