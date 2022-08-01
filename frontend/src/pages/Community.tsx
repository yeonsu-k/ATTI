import { useState, useCallback } from 'react';
import styled from 'styled-components';

import NormalPostFrame from '../components/Community/NormalPostFrame';
import SearchBar from '../components/Community/SearchBar';
import ButtonBlue from '../components/ButtonBlue';
import Category from '../components/Community/Category';

function Community(){
  return(
      <Main>
        <Category/>
        <div>
          <FlexDiv>
            <SearchBar/>
            <ButtonBlue>글쓰기</ButtonBlue>
          </FlexDiv> 
          <NormalPostFrame/>
        </div>
      </Main>
  
  );
}

const Main = styled.div`
display: flex;
flex-direction: row;
justify-content: center;
align-content: center;
align-items: center;
`;

const FlexDiv = styled.div`
display: flex;
justify-content: flex-end;
`;

  export default Community;
  