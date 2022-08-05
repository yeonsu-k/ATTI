import styled from "styled-components";

export const PeopleBox = styled.div`
  display: flex;
  flex-direction: column;
  margin-bottom: 30px;
  width: 450px;
  height: 98vh;
  background-color: #474a57;
  margin-left: auto;
  border-radius: 25px;
  align-items: center;
`;

export const ScreenText = styled.div`
  color: white;
`;

export const OpenviduBox = styled.div`
  display: flex;
  flex-direction: row;
  width: 100%;
`;

export const VideoBox = styled.div`
  /* min-height: 1vh; */
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 100%;
  height: fit-content;
  /* margin-left: auto; */
  /* background-color: #333333; */
`;
export const ChatBox = styled.div`
  width: 100%;
  height: 72%;
  background-color: white;
  margin-top: 15px;
  margin-bottom: 15px;
  border-radius: 10px;
  overflow-y: scroll;
  overflow-x: hidden;
  &::-webkit-scrollbar {
    padding-right: 15px;
    width: 8px;
    height: 8px;
    border-radius: 6px;
    background: rgba(255, 255, 255, 0.4);
  }
  &::-webkit-scrollbar-thumb {
    background: rgba(0, 0, 0, 0.3);
    border-radius: 6px;
  }
`;
export const MeetingRoom = styled.div`
  background-color: #333333;
  width: 100%;
  min-height: 100vh;
`;

export const SubStream = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  min-height: ${(props) => (props.mainStream ? null : "80vh")};
`;

export const ChattingInputBox = styled.div`
  display: flex;
  flex-direction: column;

  width: 100%;
  height: 20%;
  background-color: white;
  align-items: center;
`;

export const ChattingInput = styled.input`
  width: 80%;
  height: 70%;
  border-radius: 10px;
  border: none;
`;

export const ChattingBox = styled.div`
  width: 95%;
  height: ${(props) => (props.openAttentList ? "50%" : "100%")};
`;
export const MeetingButtonWrapper = styled.div`
  position: fixed;
  bottom: 1%;
  left: 30%;
`;
export const MeetingButtons = styled.div`
  display: flex;
  width: fit-content;
  justify-content: center;
`;

export const MeetingButton = styled.button`
  border-color: white;
  background: none;
  border-radius: 15px;
  color: white;
  width: 150px;
  height: 40px;
  margin-right: 5px;
  margin-left: 3px;
`;
