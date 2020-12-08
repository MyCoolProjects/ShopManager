import React from 'react';
import { Button, Form, InputGroup } from 'react-bootstrap';
import PropTypes from 'prop-types';

const CopyToClipboard = (props) => {
  const handleCopy = () => {
    navigator.clipboard.writeText(props.image);
  };

  return (
    <>
      <InputGroup>
        <Form.Control
          readOnly={true}
          placeholder="Image Data URI"
          defaultValue={props.image}
        />
        <InputGroup.Append>
          <Button onClick={handleCopy}>Copy</Button>
        </InputGroup.Append>
      </InputGroup>
    </>
  );
};

CopyToClipboard.propTypes = {
  handleChange: PropTypes.func.isRequired,
  image: PropTypes.string,
};

export default CopyToClipboard;
